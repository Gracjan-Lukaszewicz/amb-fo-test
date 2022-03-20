package Core.Configuration.BaseConfiguration;

import Configuration.BaseConfiguration.DefaultBaseConfiguration;

public class BaseConfigurationFactory
{
    public BaseConfiguration getConfiguration(String configurationType)
    {
        if (configurationType == null)
        {
            return null;
        }

        if (configurationType.equals("default"))
        {
            return new DefaultBaseConfiguration();

        }

        return null;
    }
}
