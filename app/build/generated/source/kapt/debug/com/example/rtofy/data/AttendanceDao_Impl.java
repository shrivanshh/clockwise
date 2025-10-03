package com.example.rtofy.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.EntityUpsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityUpsertionAdapter<Attendance> __upsertionAdapterOfAttendance;

  private final Converters __converters = new Converters();

  public AttendanceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__upsertionAdapterOfAttendance = new EntityUpsertionAdapter<Attendance>(new EntityInsertionAdapter<Attendance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT INTO `attendance` (`date`,`wentToOffice`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Attendance entity) {
        final Long _tmp = __converters.localDateToEpochDay(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, _tmp);
        }
        final int _tmp_1 = entity.getWentToOffice() ? 1 : 0;
        statement.bindLong(2, _tmp_1);
      }
    }, new EntityDeletionOrUpdateAdapter<Attendance>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE `attendance` SET `date` = ?,`wentToOffice` = ? WHERE `date` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Attendance entity) {
        final Long _tmp = __converters.localDateToEpochDay(entity.getDate());
        if (_tmp == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, _tmp);
        }
        final int _tmp_1 = entity.getWentToOffice() ? 1 : 0;
        statement.bindLong(2, _tmp_1);
        final Long _tmp_2 = __converters.localDateToEpochDay(entity.getDate());
        if (_tmp_2 == null) {
          statement.bindNull(3);
        } else {
          statement.bindLong(3, _tmp_2);
        }
      }
    });
  }

  @Override
  public Object upsert(final Attendance entry, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __upsertionAdapterOfAttendance.upsert(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Attendance>> entriesBetween(final LocalDate start, final LocalDate end) {
    final String _sql = "SELECT * FROM attendance WHERE date BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final Long _tmp = __converters.localDateToEpochDay(start);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    _argIndex = 2;
    final Long _tmp_1 = __converters.localDateToEpochDay(end);
    if (_tmp_1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp_1);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"attendance"}, new Callable<List<Attendance>>() {
      @Override
      @NonNull
      public List<Attendance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfWentToOffice = CursorUtil.getColumnIndexOrThrow(_cursor, "wentToOffice");
          final List<Attendance> _result = new ArrayList<Attendance>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Attendance _item;
            final LocalDate _tmpDate;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromEpochDay(_tmp_2);
            final boolean _tmpWentToOffice;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfWentToOffice);
            _tmpWentToOffice = _tmp_3 != 0;
            _item = new Attendance(_tmpDate,_tmpWentToOffice);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object get(final LocalDate date, final Continuation<? super Attendance> $completion) {
    final String _sql = "SELECT * FROM attendance WHERE date = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final Long _tmp = __converters.localDateToEpochDay(date);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindLong(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Attendance>() {
      @Override
      @Nullable
      public Attendance call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfWentToOffice = CursorUtil.getColumnIndexOrThrow(_cursor, "wentToOffice");
          final Attendance _result;
          if (_cursor.moveToFirst()) {
            final LocalDate _tmpDate;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfDate);
            }
            _tmpDate = __converters.fromEpochDay(_tmp_1);
            final boolean _tmpWentToOffice;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfWentToOffice);
            _tmpWentToOffice = _tmp_2 != 0;
            _result = new Attendance(_tmpDate,_tmpWentToOffice);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
