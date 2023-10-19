package ravenD.cell;

/**
 *
 * @author RAVEN
 */
public interface TableActionEventD {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onView(int row);
}