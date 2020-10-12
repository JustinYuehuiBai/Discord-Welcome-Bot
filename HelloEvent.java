package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class HelloEvent extends ListenerAdapter
{
    public HashMap<String, String> map = new HashMap<String, String>();
    public String[] questions = new String[1000];
    public int count = 0;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] messageSent = event.getMessage().getContentRaw().split(" ");
        String name = event.getMember().getUser().getName();
        if(messageSent[0].equalsIgnoreCase("Hi"))
        {
            if (messageSent[2].equalsIgnoreCase("and"))
                if (messageSent[3].equals("welcome"))
                    if (messageSent[4].equals("to"))
                        if (messageSent[5].equals("our"))
                            if (messageSent[6].equals("USC"))
                                event.getChannel().sendMessage("Welcome! check out #choose-roles and " +
                                        "#choose-roles 2! and feel free to introduce yourself in #introductions!" +
                                        "(only if you want to)").queue();
            //event.getChannel().sendMessage("Hi How Are You!").queue();
        }
        if (messageSent[0].equalsIgnoreCase("^randNum"))
        {
            int min = Integer.parseInt(messageSent[1]);
            int max = Integer.parseInt(messageSent[2]);
            int random = (int) (Math.random() * (max - min + 1) + min);
            String randomNumber = Integer.toString(random);
            event.getChannel().sendMessage("Random Number: " + randomNumber).queue();
        }
        if(messageSent[0].equalsIgnoreCase("^addQuestion"))
        {
            String question = "";
            int i = 1;
            while (messageSent[i] != "||")
            {
                question += messageSent[i];
                question += " ";
                i++;
            }
            question = question + "?";
            i++;
            String answer = "";
            for (int j = i; j < messageSent.length; j++)
            {
                answer += messageSent[i];
            }

            map.put(question, answer);
            questions[count] = question;
            count++;
            event.getChannel().sendMessage("Question Added").queue();
        }
        if(messageSent[0].equalsIgnoreCase("^askQuestion"))
        {
            int randQuestion = (int) (Math.random() * (count));
            event.getChannel().sendMessage(questions[randQuestion]);
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            event.getChannel().sendMessage(map.get(questions[randQuestion])).queue();
        }


    }
}
