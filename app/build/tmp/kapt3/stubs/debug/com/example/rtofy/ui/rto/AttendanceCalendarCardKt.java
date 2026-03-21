package com.example.rtofy.ui.rto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u001av\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a<\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007\u001a\b\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\"\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\b\u0010\u001f\u001a\u00020\u0001H\u0007\u001a\u0018\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a2\u0010\"\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006#"}, d2 = {"AttendanceCalendarCard", "", "month", "Ljava/time/YearMonth;", "holidays", "", "Ljava/time/LocalDate;", "attendanceMap", "", "", "onPreviousMonth", "Lkotlin/Function0;", "onNextMonth", "onDayTap", "Lkotlin/Function1;", "onDayLongPress", "CalendarDayCell", "date", "status", "Lcom/example/rtofy/ui/rto/CalendarDayStatus;", "isToday", "onTap", "onLongPress", "CalendarLegend", "LegendItem", "color", "Landroidx/compose/ui/graphics/Color;", "label", "", "LegendItem-DxMtmZc", "(JLjava/lang/String;)V", "WeekHeader", "buildCalendarCells", "", "resolveDayStatus", "app_debug"})
public final class AttendanceCalendarCardKt {
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.compose.runtime.Composable()
    public static final void AttendanceCalendarCard(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.time.LocalDate> holidays, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, java.lang.Boolean> attendanceMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onPreviousMonth, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNextMonth, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.LocalDate, kotlin.Unit> onDayTap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.LocalDate, kotlin.Unit> onDayLongPress) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable()
    public static final void WeekHeader() {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @androidx.compose.runtime.Composable()
    public static final void CalendarDayCell(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    com.example.rtofy.ui.rto.CalendarDayStatus status, boolean isToday, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onTap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLongPress) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CalendarLegend() {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @org.jetbrains.annotations.NotNull()
    public static final com.example.rtofy.ui.rto.CalendarDayStatus resolveDayStatus(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    java.util.Set<java.time.LocalDate> holidays, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, java.lang.Boolean> attendanceMap) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.time.LocalDate> buildCalendarCells(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month) {
        return null;
    }
}