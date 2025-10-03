package com.example.rtofy.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a8\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a$\u0010\r\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001a$\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\tH\u0007\u001a\u0010\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0016"}, d2 = {"DashboardCard", "", "ui", "Lcom/example/rtofy/ui/UiState;", "EditScreen", "vm", "Lcom/example/rtofy/ui/RtoViewModel;", "HolidaysCard", "onAdd", "Lkotlin/Function1;", "Ljava/time/LocalDate;", "onRemove", "HomeScreen", "QuickLogCard", "onYes", "Lkotlin/Function0;", "onNo", "SettingsCard", "fyStart", "", "onSave", "SettingsScreen", "app_release"})
public final class ComponentsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void HomeScreen(@org.jetbrains.annotations.NotNull()
    com.example.rtofy.ui.RtoViewModel vm) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull()
    com.example.rtofy.ui.RtoViewModel vm) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void EditScreen(@org.jetbrains.annotations.NotNull()
    com.example.rtofy.ui.RtoViewModel vm) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SettingsCard(int fyStart, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onSave) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void DashboardCard(@org.jetbrains.annotations.NotNull()
    com.example.rtofy.ui.UiState ui) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void HolidaysCard(@org.jetbrains.annotations.NotNull()
    com.example.rtofy.ui.UiState ui, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.LocalDate, kotlin.Unit> onAdd, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.LocalDate, kotlin.Unit> onRemove) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void QuickLogCard(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onYes, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onNo) {
    }
}