package MenuRegex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum LoginMenuRegex {
    CREATE1("^user create (--username|-u) (?<username>[\\S]+) (--nickname|-n) (?<nickname>[\\S]+) (--password|-p) (?<password>[\\S]+)$"),
    CREATE2("^user create (--username|-u) (?<username>[\\S]+) (--password|-p) (?<password>[\\S]+) (--nickname|-n) (?<nickname>[\\S]+)$"),
    CREATE3("^user create (--nickname|-n) (?<nickname>[\\S]+) (--username|-u) (?<username>[\\S]+) (--password|-p) (?<password>[\\S]+)$"),
    CREATE4("^user create (--nickname|-n) (?<nickname>[\\S]+) (--password|-p) (?<password>[\\S]+) (--username|-u) (?<username>[\\S]+)$"),
    CREATE5("^user create (--password|-p) (?<password>[\\S]+) (--username|-u) (?<username>[\\S]+) (--nickname|-n) (?<nickname>[\\S]+)$"),
    CREATE6("^user create (--password|-p) (?<password>[\\S]+) (--nickname|-n) (?<nickname>[\\S]+) (--username|-u) (?<username>[\\S]+)$"),
    CREATE(""),
    USERNAMEFORMATREGEX("[a-zA-Z0-9_]+"),
    NICKNAMEFORMATREGEX("[a-zA-Z ]+"),
    PASSWORDFORMATREGEX("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\*\\.\\!\\@\\$\\%\\^\\&\\(\\)\\{\\}\\[\\]\\:\\;\\<\\>\\,\\?\\/\\~\\_\\+\\-\\=\\|]).{8,32}"),
    LOGIN1("^user login (--username|-u) \\<(?<username>\\S+)\\> (--password|-p) \\<(?<password>\\S+)\\>$"),
    LOGIN2("^user login (--password|-p) \\<(?<password>[\\S]+)\\> (--username|-u) \\<(?<username>[\\S]+)\\>$"),
    LOGIN(""),
    SHOWCURRENTMENU("menu show-current"),
    ENTER("^menu enter (?<menuname>(Profile menu)|(Game menu)|(Main menu)|(Login menu))"),
    SHOWMENU("^menu show-current"),
    EXIT("^menu exit");
    //TODO complete enter menu regex

    private final String regex;
    private static final ArrayList<LoginMenuRegex> createRegexes = new ArrayList<>() {
        {
            add(CREATE1);
            add(CREATE2);
            add(CREATE3);
            add(CREATE4);
            add(CREATE5);
            add(CREATE6);
        }
    };
    private static final ArrayList<LoginMenuRegex> loginRegexes = new ArrayList<>() {
        {
            add(LOGIN1);
            add(LOGIN2);
        }
    };

    LoginMenuRegex(String regex) {
        this.regex = regex;
    }

    private static Matcher create(String input) {
        for (LoginMenuRegex command : createRegexes) {
            Matcher matcher = Pattern.compile(command.regex).matcher(input);
            if (matcher.matches()) {
                return matcher;
            }
        }
        return null;

    }

    private static Matcher login(String input) {
        for (LoginMenuRegex command : loginRegexes) {
            Matcher matcher = Pattern.compile(command.regex).matcher(input);
            if (matcher.matches()) {
                return matcher;
            }
        }
        return null;
    }

    public static Matcher getMatcher(String input, LoginMenuRegex command) {
        if (command.equals(CREATE))
            return create(input);
        if (command.equals(LOGIN))
            return login(input);
        Matcher matcher = Pattern.compile(command.regex).matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}
