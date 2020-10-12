import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class USCBot
{
    public String prefix = "^";

    public static void main(String[] args) throws LoginException
    {
        JDA jda = JDABuilder.createDefault("NzYxNDM3NjE4MzE0Njc0MTg2.X3amCw.lzaT2KPX3LNwCILmRpatdP2PDD8").build();

        jda.addEventListener(new HelloEvent());
    }
}
