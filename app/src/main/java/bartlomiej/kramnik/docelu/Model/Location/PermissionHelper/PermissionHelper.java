package bartlomiej.kramnik.docelu.Model.Location.PermissionHelper;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

/**
 * Checking and asking for permissions
 */

public class PermissionHelper {

    private Activity context;
    private PermissionRequestResponseListener listener;

    public PermissionHelper(Activity context) {
        this.context = context;
    }

    private static final int permissionLocation = 533;

    public boolean chechkLocationPermission() {
        int permission1 = context.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION);
        int permission2 = context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    public void requestPermission(PermissionRequestResponseListener listener) {
        this.listener = listener;
        ActivityCompat.requestPermissions(context,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                permissionLocation);
    }

    public void permissionResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case permissionLocation: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    listener.permissionsGranted();

                } else {
                    listener.permissionsDenied();
                }
                return;
            }
        }

    }
}
