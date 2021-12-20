package App;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;

public class MyBot {
	Bot myBot;
	Chat chatSession;
	String botName;
	
	public MyBot() {
		botName = "testo";
		myBot = new Bot(botName, getResourcesPath());
		chatSession = new Chat(myBot);
		myBot.writeAIMLFiles();
        myBot.brain.nodeStats();
	}
	
	public String giveReply(String x) {
		String temp = chatSession.multisentenceRespond(x);
		String regex = "\\s+";
	      Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(temp);
	      String reply = matcher.replaceAll(" ");
	      
		return reply;
	}
	
	
	public static String getResourcesPath() {
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        path = path.substring(0, path.length() - 2);
        String resourcesPath = path + File.separator + "src" + File.separator + "resources";
        return resourcesPath;
    }

}
