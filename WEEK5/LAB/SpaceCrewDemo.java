final class SecurityClearance {
    private final String clearanceId;
    private final String level;
    private final String[] authorizedSections;
    private final long expirationDate;

    public SecurityClearance(String id, String level, String[] sections, long exp) {
        this.clearanceId = id;
        this.level = level;
        this.authorizedSections = sections.clone();
        this.expirationDate = exp;
    }

    public String getClearanceId() { return clearanceId; }
    public String getLevel() { return level; }
    public String[] getAuthorizedSections() { return authorizedSections.clone(); }
    public long getExpirationDate() { return expirationDate; }
    public final boolean canAccess(String section) {
        for(String s : authorizedSections) if(s.equals(section)) return true;
        return false;
    }
}

public class SpaceCrewDemo {
    private final String crewId;
    private final SecurityClearance clearance;
    private int missionCount;
    private double spaceHours;

    public SpaceCrewDemo(String crewId, SecurityClearance clearance) {
        this.crewId = crewId;
        this.clearance = clearance;
        this.missionCount = 0;
        this.spaceHours = 0;
    }

    public String getCrewId() { return crewId; }
    public SecurityClearance getClearance() { return clearance; }
    public int getMissionCount() { return missionCount; }
    public double getSpaceHours() { return spaceHours; }
    public void addMission(double hours) { missionCount++; spaceHours += hours; }
    public final boolean canBePromoted() { return missionCount > 5 && spaceHours > 50; }

    public static void main(String[] args) {
        SecurityClearance sc = new SecurityClearance("SC001","High", new String[]{"Lab","Engine"}, 20300101);
        SpaceCrewDemo crew = new SpaceCrewDemo("C001", sc);
        crew.addMission(12);
        crew.addMission(15);
        System.out.println(crew.getCrewId() + " has missions: " + crew.getMissionCount());
        System.out.println("Can be promoted? " + crew.canBePromoted());
        System.out.println("Can access Lab? " + crew.getClearance().canAccess("Lab"));
    }
}
