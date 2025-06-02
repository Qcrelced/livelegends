package livelegends.livelegendsbackend.core.common.profile.match;

import livelegends.livelegendsbackend.core.common.profile.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

}