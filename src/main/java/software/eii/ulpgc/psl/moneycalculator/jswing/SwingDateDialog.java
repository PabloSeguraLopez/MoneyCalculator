package software.eii.ulpgc.psl.moneycalculator.jswing;

import com.toedter.calendar.JCalendar;
import software.eii.ulpgc.psl.moneycalculator.DateDialog;

import java.time.LocalDate;
import java.time.ZoneId;

public class SwingDateDialog extends JCalendar implements DateDialog {
    @Override
    public LocalDate get() {
        return this.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
