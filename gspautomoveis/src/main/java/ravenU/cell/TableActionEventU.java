package ravenU.cell;

/**
 *
 * @author RAVEN
 */
public interface TableActionEventU {

    public void onEdit(int row);

    public void onDelete(int row);

    public void onView(int row);
}