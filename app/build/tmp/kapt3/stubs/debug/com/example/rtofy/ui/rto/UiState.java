package com.example.rtofy.ui.rto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B\u00cb\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00c6\u0003J\u0015\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012H\u00c6\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0013H\u00c6\u0003\u00a2\u0006\u0002\u00102J\t\u00109\u001a\u00020\u0016H\u00c6\u0003J\t\u0010:\u001a\u00020\u0016H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0003H\u00c6\u0003J\t\u0010=\u001a\u00020\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\u0003H\u00c6\u0003J\t\u0010@\u001a\u00020\u0003H\u00c6\u0003J\t\u0010A\u001a\u00020\nH\u00c6\u0003J\t\u0010B\u001a\u00020\u0003H\u00c6\u0003J\t\u0010C\u001a\u00020\u0003H\u00c6\u0003J\t\u0010D\u001a\u00020\nH\u00c6\u0003J\u00d2\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\u00132\b\u0010H\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010I\u001a\u00020\u0003H\u00d6\u0001J\t\u0010J\u001a\u00020\nH\u00d6\u0001R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010,R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102\u00a8\u0006K"}, d2 = {"Lcom/example/rtofy/ui/rto/UiState;", "", "fyStartMonth", "", "qStart", "Ljava/time/LocalDate;", "qEnd", "bizToDate", "officeToDate", "rtoToDatePctString", "", "bizFull", "officeFull", "rtoFullPctString", "holidays", "", "dates", "attendanceMap", "", "", "todayStatus", "rtoToDatePct", "", "rtoFullPct", "notificationHour", "notificationMinute", "(ILjava/time/LocalDate;Ljava/time/LocalDate;IILjava/lang/String;IILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Boolean;FFII)V", "getAttendanceMap", "()Ljava/util/Map;", "getBizFull", "()I", "getBizToDate", "getDates", "()Ljava/util/List;", "getFyStartMonth", "getHolidays", "getNotificationHour", "getNotificationMinute", "getOfficeFull", "getOfficeToDate", "getQEnd", "()Ljava/time/LocalDate;", "getQStart", "getRtoFullPct", "()F", "getRtoFullPctString", "()Ljava/lang/String;", "getRtoToDatePct", "getRtoToDatePctString", "getTodayStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/time/LocalDate;Ljava/time/LocalDate;IILjava/lang/String;IILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/Boolean;FFII)Lcom/example/rtofy/ui/rto/UiState;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class UiState {
    private final int fyStartMonth = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate qStart = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate qEnd = null;
    private final int bizToDate = 0;
    private final int officeToDate = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rtoToDatePctString = null;
    private final int bizFull = 0;
    private final int officeFull = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rtoFullPctString = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.time.LocalDate> holidays = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.time.LocalDate> dates = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.time.LocalDate, java.lang.Boolean> attendanceMap = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean todayStatus = null;
    private final float rtoToDatePct = 0.0F;
    private final float rtoFullPct = 0.0F;
    private final int notificationHour = 0;
    private final int notificationMinute = 0;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    public UiState(int fyStartMonth, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate qStart, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate qEnd, int bizToDate, int officeToDate, @org.jetbrains.annotations.NotNull()
    java.lang.String rtoToDatePctString, int bizFull, int officeFull, @org.jetbrains.annotations.NotNull()
    java.lang.String rtoFullPctString, @org.jetbrains.annotations.NotNull()
    java.util.List<java.time.LocalDate> holidays, @org.jetbrains.annotations.NotNull()
    java.util.List<java.time.LocalDate> dates, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, java.lang.Boolean> attendanceMap, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean todayStatus, float rtoToDatePct, float rtoFullPct, int notificationHour, int notificationMinute) {
        super();
    }
    
    public final int getFyStartMonth() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getQStart() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getQEnd() {
        return null;
    }
    
    public final int getBizToDate() {
        return 0;
    }
    
    public final int getOfficeToDate() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRtoToDatePctString() {
        return null;
    }
    
    public final int getBizFull() {
        return 0;
    }
    
    public final int getOfficeFull() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRtoFullPctString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.time.LocalDate> getHolidays() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.time.LocalDate> getDates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.time.LocalDate, java.lang.Boolean> getAttendanceMap() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getTodayStatus() {
        return null;
    }
    
    public final float getRtoToDatePct() {
        return 0.0F;
    }
    
    public final float getRtoFullPct() {
        return 0.0F;
    }
    
    public final int getNotificationHour() {
        return 0;
    }
    
    public final int getNotificationMinute() {
        return 0;
    }
    
    @androidx.annotation.RequiresApi(value = 26)
    public UiState() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.time.LocalDate> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.time.LocalDate> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.time.LocalDate, java.lang.Boolean> component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component13() {
        return null;
    }
    
    public final float component14() {
        return 0.0F;
    }
    
    public final float component15() {
        return 0.0F;
    }
    
    public final int component16() {
        return 0;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component3() {
        return null;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.rtofy.ui.rto.UiState copy(int fyStartMonth, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate qStart, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate qEnd, int bizToDate, int officeToDate, @org.jetbrains.annotations.NotNull()
    java.lang.String rtoToDatePctString, int bizFull, int officeFull, @org.jetbrains.annotations.NotNull()
    java.lang.String rtoFullPctString, @org.jetbrains.annotations.NotNull()
    java.util.List<java.time.LocalDate> holidays, @org.jetbrains.annotations.NotNull()
    java.util.List<java.time.LocalDate> dates, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, java.lang.Boolean> attendanceMap, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean todayStatus, float rtoToDatePct, float rtoFullPct, int notificationHour, int notificationMinute) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}