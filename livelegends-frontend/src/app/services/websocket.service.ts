import { Injectable } from '@angular/core';
import { Client, IMessage } from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { Subject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient: Client;
  private matchSubject = new Subject<any>();

  constructor() {
    this.stompClient = new Client({
      webSocketFactory: () => new SockJS('http://localhost:8080/ws/matchs') as unknown as WebSocket,
      reconnectDelay: 5000,
      debug: str => console.log('[STOMP]', str)
    });

    this.stompClient.onConnect = () => {
      console.log('[WebSocket] Connecté');

      this.stompClient.subscribe('/ws/websocket', (message: IMessage) => {
        const match = JSON.parse(message.body);
        this.matchSubject.next(match);
      });
    };

    this.stompClient.onStompError = (frame) => {
      console.error('[WebSocket] STOMP error:', frame);
    };

    this.stompClient.activate();
  }

  onMatchReceived(): Observable<any> {
    return this.matchSubject.asObservable();
  }

  sendMatch(match: any): void {
    if (this.stompClient && this.stompClient.connected) {
      this.stompClient.publish({
        destination: '/ws/matchs',
        body: JSON.stringify(match)
      });
    } else {
      console.warn('Client STOMP non connecté');
    }
  }

  disconnect(): void {
    this.stompClient.deactivate();
  }
}
