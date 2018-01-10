package bartlomiej.kramnik.docelu.Model.Location.PermissionHelper;

/**
 * Interface for locations permissions menager
 */

public interface PermissionRequestResponseListener {
    public void permissionsGranted();

    public void permissionsDenied();
}
