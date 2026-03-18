package com.example.rtofy.notify;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/rtofy/notify/AlarmScheduler;", "", "()V", "REQUEST_CODE_DAILY_ALARM", "", "nextTriggerTime", "", "hour", "minute", "scheduleNextMorningPrompt", "", "context", "Landroid/content/Context;", "app_release"})
public final class AlarmScheduler {
    private static final int REQUEST_CODE_DAILY_ALARM = 2001;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.rtofy.notify.AlarmScheduler INSTANCE = null;
    
    private AlarmScheduler() {
        super();
    }
    
    public final void scheduleNextMorningPrompt(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int hour, int minute) {
    }
    
    private final long nextTriggerTime(int hour, int minute) {
        return 0L;
    }
}