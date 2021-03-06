package org.klv.john.database.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.locks.ReentrantLock;

import org.klv.john.objects.Carte;
import org.klv.john.objects.NPC_tmpl.NPC;

import org.klv.john.common.World;

import org.klv.john.core.Console;
import org.klv.john.database.AbstractDAO;

public class NpcData extends AbstractDAO<NPC>{

	public NpcData(Connection connection, ReentrantLock locker) {
		super(connection, locker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(NPC obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean create(int mapid, int npcid, int cellid, int orientation) {
		String baseQuery = "INSERT INTO `npcs`" + " VALUES (?,?,?,?);";
		try {
			PreparedStatement statement = connection.prepareStatement(baseQuery);
			statement.setInt(1, mapid);
			statement.setInt(2, npcid);
			statement.setInt(3, cellid);
			statement.setInt(4, orientation);

			execute(statement);
			return true;
		} catch (Exception e) {
			Console.instance.writeln("SQL ERROR(NpcData): "+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(NPC obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean delete(int mapid, int cellid) {
		String baseQuery = "DELETE FROM npcs WHERE mapid = "+mapid+" AND cellid = "+cellid;
		execute(baseQuery);
		return true;
	}

	@Override
	public boolean update(NPC obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NPC load(int id) {
		NPC npc = null;
		try {
			ResultSet result = getData("SELECT * FROM npcs WHERE mapid = "+id);
			if(result.next()) {
				Carte map = World.data.getCarte(result.getShort("mapid"));
				
				if (map == null)
					return null;
				
				npc = map.addNpc(result.getInt("npcid"), result.getInt("cellid"),
						result.getInt("orientation"));
			}
			closeResultSet(result);
		} catch (Exception e) {
			Console.instance.writeln("SQL ERROR(NpcData): "+e.getMessage());
		}
		return npc;
	}
}
