package com.example.rtofy.notify;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/example/rtofy/notify/Scheduler;", "", "()V", "scheduleDailyPrompt", "", "workManager", "Landroidx/work/WorkManager;", "hour", "", "minute", "app_release"})
public final class Scheduler {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.rtofy.notify.Scheduler INSTANCE = null;
    
    private Scheduler() {
        super();
    }
    
    public final void scheduleDailyPrompt(@org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager workManager, int hour, int minute) {
    }
}