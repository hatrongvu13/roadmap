package org.jax.cli;

import org.apache.commons.cli.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Options options = new Options();
        Option name = new Option("f", "name", true, "First Name");
        name.setRequired(true);
        options.addOption(name);
        Option lastName = new Option("l", "lastname", true, "Last Name");
        lastName.setRequired(true);
        options.addOption(lastName);
        Option email = new Option("e", "email", true, "Email");
        email.setRequired(true);
        options.addOption(email);
        Option mobileNumber = new Option("m", "mobilenumber", true, "Mobile Number");
        mobileNumber.setRequired(false);
        options.addOption(mobileNumber);
        HelpFormatter formatter = new HelpFormatter();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("User Profile Info", options);
            System.exit(1);
            return;
        }
        System.out.println("User First Name is: " + cmd.getOptionValue("name"));
        System.out.println("User Last Name is: " + cmd.getOptionValue("lastname"));
        System.out.println("User Email is: " + cmd.getOptionValue("email"));
        if (cmd.hasOption("m")) {
            System.out.println("User Mobile Number is: " + cmd.getOptionValue("mobilenumber"));
        }
    }
}
