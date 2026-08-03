//package interview.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Feedback {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    private Integer technicalRating;
//
//    private Integer communicationRating;
//
//    @Column(length = 1000)
//    private String comments;
//
//    @OneToOne
//    @JoinColumn(name = "interview_id")
//    private Interview interview;
//
//    public Feedback() {
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public Integer getTechnicalRating() {
//        return technicalRating;
//    }
//
//    public void setTechnicalRating(Integer technicalRating) {
//        this.technicalRating = technicalRating;
//    }
//
//    public Integer getCommunicationRating() {
//        return communicationRating;
//    }
//
//    public void setCommunicationRating(Integer communicationRating) {
//        this.communicationRating = communicationRating;
//    }
//
//    public String getComments() {
//        return comments;
//    }
//
//    public void setComments(String comments) {
//        this.comments = comments;
//    }
//
//    public Interview getInterview() {
//        return interview;
//    }
//
//    public void setInterview(Interview interview) {
//        this.interview = interview;
//    }
//}


package interview.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Technical Rating is required")
    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private Integer technicalRating;

    @NotNull(message = "Communication Rating is required")
    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private Integer communicationRating;

    @NotBlank(message = "Comments are required")
    @Column(length = 1000)
    private String comments;

    @NotNull(message = "Interview is required")
    @OneToOne
    @JoinColumn(name = "interview_id")
    private Interview interview;

    public Feedback() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTechnicalRating() {
        return technicalRating;
    }

    public void setTechnicalRating(Integer technicalRating) {
        this.technicalRating = technicalRating;
    }

    public Integer getCommunicationRating() {
        return communicationRating;
    }

    public void setCommunicationRating(Integer communicationRating) {
        this.communicationRating = communicationRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }
}
