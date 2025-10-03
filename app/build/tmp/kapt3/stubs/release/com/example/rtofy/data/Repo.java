package com.example.rtofy.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0015J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u00100\u000fJ \u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010\u0019\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u001e\u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/example/rtofy/data/Repo;", "", "db", "Lcom/example/rtofy/data/AppDatabase;", "(Lcom/example/rtofy/data/AppDatabase;)V", "attendance", "Lcom/example/rtofy/data/AttendanceDao;", "holidays", "Lcom/example/rtofy/data/HolidayDao;", "addHoliday", "", "date", "Ljava/time/LocalDate;", "(Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attendanceFlowBetween", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/rtofy/data/Attendance;", "a", "b", "businessDaysBetween", "", "(Ljava/time/LocalDate;Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "currentFyQuarter", "Lkotlin/Pair;", "today", "fyStartMonth", "deleteHoliday", "holidaysFlow", "Lcom/example/rtofy/data/Holiday;", "markToday", "went", "", "(ZLjava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "officeDaysBetween", "setAttendance", "(Ljava/time/LocalDate;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"})
public final class Repo {
    @org.jetbrains.annotations.NotNull()
    private final com.example.rtofy.data.AppDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.rtofy.data.AttendanceDao attendance = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.rtofy.data.HolidayDao holidays = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.rtofy.data.Repo.Companion Companion = null;
    
    public Repo(@org.jetbrains.annotations.NotNull()
    com.example.rtofy.data.AppDatabase db) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markToday(boolean went, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate today, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setAttendance(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, boolean went, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.rtofy.data.Holiday>> holidaysFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addHoliday(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteHoliday(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.Pair<java.time.LocalDate, java.time.LocalDate> currentFyQuarter(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate today, int fyStartMonth) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object businessDaysBetween(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate a, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate b, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.rtofy.data.Attendance>> attendanceFlowBetween(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate a, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate b) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object officeDaysBetween(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate a, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate b, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/rtofy/data/Repo$Companion;", "", "()V", "get", "Lcom/example/rtofy/data/Repo;", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.rtofy.data.Repo get(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}