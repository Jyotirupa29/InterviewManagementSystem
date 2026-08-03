//package interview.entity;
//
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//import interview.enums.InterviewMode;
//import interview.enums.InterviewStatus;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Interview {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "hr_id")
//    private HR hr;
//    
//    private LocalDate interviewDate;
//
//    private LocalTime interviewTime;
//
//    @Enumerated(EnumType.STRING)
//    private InterviewMode mode;
//
//    @Enumerated(EnumType.STRING)
//    private InterviewStatus status;
//    
//    private String location; 
//
//    @ManyToOne
//    @JoinColumn(name = "candidate_id")
//    private Candidate candidate;
//    
//    @OneToOne(mappedBy = "interview",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true)
//     private Feedback feedback;
//
//    public Interview() {
//    }
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public HR getHr() {
//		return hr;
//	}
//
//	public void setHr(HR hr) {
//		this.hr = hr;
//	}
//
//	public LocalDate getInterviewDate() {
//		return interviewDate;
//	}
//
//	public void setInterviewDate(LocalDate interviewDate) {
//		this.interviewDate = interviewDate;
//	}
//
//	public LocalTime getInterviewTime() {
//		return interviewTime;
//	}
//
//	public void setInterviewTime(LocalTime interviewTime) {
//		this.interviewTime = interviewTime;
//	}
//
//	public InterviewMode getMode() {
//		return mode;
//	}
//
//	public void setMode(InterviewMode mode) {
//		this.mode = mode;
//	}
//
//	public InterviewStatus getStatus() {
//		return status;
//	}
//
//	public void setStatus(InterviewStatus status) {
//		this.status = status;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public Candidate getCandidate() {
//		return candidate;
//	}
//
//	public void setCandidate(Candidate candidate) {
//		this.candidate = candidate;
//	}
//
//	public Feedback getFeedback() {
//		return feedback;
//	}
//
//	public void setFeedback(Feedback feedback) {
//		this.feedback = feedback;
//	}
//
//	
//}



package interview.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import interview.enums.InterviewMode;
import interview.enums.InterviewStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Please select an HR")
    @ManyToOne
    @JoinColumn(name = "hr_id")
    private HR hr;

    @NotNull(message = "Interview date is required")
    private LocalDate interviewDate;

    @NotNull(message = "Interview time is required")
    private LocalTime interviewTime;

    @NotNull(message = "Please select interview mode")
    @Enumerated(EnumType.STRING)
    private InterviewMode mode;

    @NotNull(message = "Please select interview status")
    @Enumerated(EnumType.STRING)
    private InterviewStatus status;

    @NotBlank(message = "Meeting link or location is required")
    private String location;

    @NotNull(message = "Please select a candidate")
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @OneToOne(mappedBy = "interview",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Feedback feedback;

    public Interview() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HR getHr() {
        return hr;
    }

    public void setHr(HR hr) {
        this.hr = hr;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    public LocalTime getInterviewTime() {
        return interviewTime;
    }

    public void setInterviewTime(LocalTime interviewTime) {
        this.interviewTime = interviewTime;
    }

    public InterviewMode getMode() {
        return mode;
    }

    public void setMode(InterviewMode mode) {
        this.mode = mode;
    }

    public InterviewStatus getStatus() {
        return status;
    }

    public void setStatus(InterviewStatus status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
}
