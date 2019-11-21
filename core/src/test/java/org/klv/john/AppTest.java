package org.klv.john;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.klv.john.core.Main;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldStart()
    {
        Main.main(null);
        Main.closeServers();
        assertTrue(true);
    }
}
