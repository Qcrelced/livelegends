package livelegends.livelegendsbackend.core.player.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerGameRepository extends JpaRepository<PlayerGame, Long> {

}

