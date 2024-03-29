package cal;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;

public class Entries {

    private final Hashtable<String, Entry> entries;
    private static final String[] time = { "8am", "9am", "10am", "11am",
            "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm" };
    public static final int rows = 12;

    public Entries() {
        entries = new Hashtable<>(rows);
        for (int i = 0; i < rows; i++) {
            entries.put(time[i], new Entry(time[i]));
        }
    }

    public int getRows() {
        return rows;
    }

    public Entry getEntry(int index) {
        return this.entries.get(time[index]);
    }

    public int getIndex(String tm) {
        for (int i = 0; i < rows; i++)
            if (tm.equals(time[i]))
                return i;
        return -1;
    }

    public void processRequest(HttpServletRequest request, String tm) {
        int index = getIndex(tm);
        if (index >= 0) {
            String descr = request.getParameter("description");
            entries.get(time[index]).setDescription(descr);
        }
    }

}