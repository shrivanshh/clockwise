package com.example.rtofy.ui.rto;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0007\u001a:\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bH\u0002\u00a2\u0006\u0002\u0010\u0017\u001a\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u001e\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0019"}, d2 = {"shortFmt", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "getShortFmt", "()Ljava/time/format/DateTimeFormatter;", "CompactRtoGauge", "", "progress", "", "percentText", "", "MiniStatRow", "label", "value", "RtoSummaryPanel", "title", "businessDays", "", "officeDays", "modifier", "Landroidx/compose/ui/Modifier;", "gaugeColor", "Landroidx/compose/ui/graphics/Color;", "(F)J", "rtoStatusLabel", "app_debug"})
public final class RtoGaugeKt {
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.O)
    private static final java.time.format.DateTimeFormatter shortFmt = null;
    
    public static final java.time.format.DateTimeFormatter getShortFmt() {
        return null;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RtoSummaryPanel(@org.jetbrains.annotations.NotNull()
    java.lang.String title, float progress, @org.jetbrains.annotations.NotNull()
    java.lang.String percentText, int businessDays, int officeDays, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CompactRtoGauge(float progress, @org.jetbrains.annotations.NotNull()
    java.lang.String percentText) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MiniStatRow(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    private static final java.lang.String rtoStatusLabel(float progress) {
        return null;
    }
    
    private static final long gaugeColor(float progress) {
        return 0L;
    }
}