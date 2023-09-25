package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team team = gradeDB.getMyTeam();
        int total_grades = 0;
        int num_of_members = 0;

        for (String member : team.getMembers()) {
            total_grades += gradeDB.getGrade(member, course).getGrade();
            num_of_members += 1;
        }
        return (float) total_grades / num_of_members;
    }
}
