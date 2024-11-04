package lk.ijse.entity;


import jakarta.persistence.*;

@Entity
public class EnrollmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "enrollmentId")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "program_code")
    private Program program;

    private String programFee;

    public EnrollmentDetails() {
    }

    public EnrollmentDetails(String programFee, Program program, Enrollment enrollment, Integer id) {
        this.programFee = programFee;
        this.program = program;
        this.enrollment = enrollment;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public String getProgramFee() {
        return programFee;
    }

    public void setProgramFee(String programFee) {
        this.programFee = programFee;
    }


}
