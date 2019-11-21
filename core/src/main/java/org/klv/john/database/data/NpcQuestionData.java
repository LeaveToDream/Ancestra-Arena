package org.klv.john.database.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.concurrent.locks.ReentrantLock;

import org.klv.john.objects.NPC_tmpl.NPC_question;

import org.klv.john.common.World;

import org.klv.john.core.Console;
import org.klv.john.database.AbstractDAO;

public class NpcQuestionData extends AbstractDAO<NPC_question>{

	public NpcQuestionData(Connection connection, ReentrantLock locker) {
		super(connection, locker);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(NPC_question obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(NPC_question obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(NPC_question obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NPC_question load(int id) {
		NPC_question question = null;
		try {
			ResultSet statement = getData("SELECT * FROM npc_questions WHERE ID = "+id);
			
			if(statement.next()) {
				question = new NPC_question(statement.getInt("ID"), statement
						.getString("responses"), statement.getString("params"), statement
						.getString("cond"), statement.getInt("ifFalse"));
				World.data.addNPCQuestion(question);
			}
			closeResultSet(statement);
		} catch (Exception e) {
			Console.instance.println("SQL ERROR(NpcQuestionData): "+e.getMessage());
		}
		return question;
	}
}
