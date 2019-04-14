package com.github.tartaricacid.bakaintouhou.common.command;

import com.github.tartaricacid.bakaintouhou.common.capability.IPower;
import com.github.tartaricacid.bakaintouhou.common.capability.IScore;
import com.github.tartaricacid.bakaintouhou.common.capability.PowerProvider;
import com.github.tartaricacid.bakaintouhou.common.capability.ScoreProvider;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainCommand extends CommandBase {
    @Override
    public String getName() {
        return "baka_in_touhou";
    }

    @Override
    public List<String> getAliases() {
        List<String> aliases = new ArrayList<>();
        aliases.add("touhou");
        aliases.add("th");
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length >= 3) {
            if (args[0].equals("power")) {
                commandPower(server, sender, args);
                return;
            }
            if (args[0].equals("score")) {
                commandScore(server, sender, args);
                return;
            }
        }
        sender.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.usage"));
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        List<String> command = new ArrayList<>();

        switch (args.length) {
            case 1:
                command.add("power");
                command.add("score");
                break;
            case 2:
                command.add("get");
                command.add("set");
                command.add("add");
                command.add("min");
                break;
            case 3:
                command.addAll(Arrays.asList(server.getOnlinePlayerNames()));
                break;
        }
        return getListOfStringsMatchingLastWord(args, command);
    }

    private void commandPower(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = getPlayer(server, sender, args[2]);
        IPower power = player.getCapability(PowerProvider.POWER_CAP, null);
        float num = (args.length >= 4) ? (float) parseDouble(args[3]) : 1;

        switch (args[1]) {
            case "get":
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.power.info", power.get()));
                break;
            case "set":
                power.set(num);
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.power.info", power.get()));
                break;
            case "add":
                power.add(num);
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.power.info", power.get()));
                break;
            case "min":
                power.min(num);
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.power.info", power.get()));
                break;
        }
    }

    private void commandScore(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        EntityPlayer player = getPlayer(server, sender, args[2]);
        IScore score = player.getCapability(ScoreProvider.SCORE_CAP, null);
        float num = (args.length >= 4) ? (float) parseDouble(args[3]) : 1;

        switch (args[1]) {
            case "get":
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.score.info", score.get()));
                break;
            case "set":
                score.set(num);
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.score.info", score.get()));
                break;
            case "add":
                score.add(num);
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.score.info", score.get()));
                break;
            case "min":
                score.min(num);
                player.sendMessage(new TextComponentTranslation("command.bakaintouhou.main.score.info", score.get()));
                break;
        }
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "command.bakaintouhou.main.usage";
    }
}
