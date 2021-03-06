/*
 * Copyright (C) 2020 Muntashir Al-Islam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.muntashirakon.AppManager.servermanager.remote;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;

import io.github.muntashirakon.AppManager.BuildConfig;
import io.github.muntashirakon.AppManager.server.common.ClassCallerProcessor;
import io.github.muntashirakon.AppManager.server.common.FLog;

public class RestartHandler extends ClassCallerProcessor {

  private static final String TAG = "RestartHandler";

  public RestartHandler(Context mPackageContext,
      Context mSystemContext, byte[] bytes) {
    super(mPackageContext, mSystemContext, bytes);
  }

  @Override
  public Bundle proxyInvoke(Bundle bundle) throws Throwable {
    Runtime.getRuntime().exec("sh /sdcard/Android/data/" + BuildConfig.APPLICATION_ID +
            "/files/run_server.sh " + Process.myPid());
    FLog.log("RestartHandler -----------exec  --- ");
    return bundle;
  }
}
