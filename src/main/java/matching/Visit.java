package matching;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Visit_table")
public class Visit {

    @Id
    private Long matchId;
    private String teacher;
    private String visitDate;

    @PreUpdate
    public void onPreUpdate(){
        VisitAssigned visitAssigned = new VisitAssigned();
        BeanUtils.copyProperties(this, visitAssigned);
        visitAssigned.publishAfterCommit();


    }

    @PostRemove
    public void onPostRemove(){
        VisitCanceled visitCanceled = new VisitCanceled();
        BeanUtils.copyProperties(this, visitCanceled);
        visitCanceled.publishAfterCommit();


    }



    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }




}
