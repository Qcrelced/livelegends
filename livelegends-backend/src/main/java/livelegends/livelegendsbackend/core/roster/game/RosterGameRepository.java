package livelegends.livelegendsbackend.core.roster.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RosterGameRepository extends JpaRepository<RosterGame, Long> {

}

