/*
 *  ICTK - Internet Chess ToolKit
 *  More information is available at http://ictk.sourceforge.net
 *  Copyright (C) 2002 J. Varsoke <jvarsoke@ghostmanonfirst.com>
 *  All rights reserved.
 *
 *  $Id$
 *
 *  This file is part of ICTK.
 *
 *  ICTK is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  ICTK is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with ICTK; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package ictk.boardgame.chess.net.ics.event;
import ictk.boardgame.chess.net.ics.*;

import java.util.regex.*;
import java.io.IOException;

public abstract class ICSGameResultEvent extends ICSEvent 
                                      implements ICSBoardEvent {
   public static final int GAME_RESULT_EVENT 
                = ICSEvent.GAME_RESULT_EVENT;

   //instance/////////////////////////////////////////////////////////////
   protected String white, black;
   protected int boardNumber;
   protected ICSResult result;

   public ICSGameResultEvent (ICSProtocolHandler server) {
      super(server, GAME_RESULT_EVENT);
   }

   //getters and setters//////////////////////////////////////////////////////
   public String getWhitePlayer () { return white; }
   public void setWhitePlayer (String player) { white = player; }

   public String getBlackPlayer () { return black; }
   public void setBlackPlayer (String player) { black = player; }

   public int getBoardNumber () { return boardNumber; }
   public void setBoardNumber (int board) { boardNumber = board; }

   public String getDescription () { return getMessage(); }
   public void setDescription (String s) { setMessage(s); }

   public ICSResult getResult () { return result; }
   public void setResult (ICSResult res) { result = res; }

   ////////////////////////////////////////////////////////////////////////
   public String getReadable () {
      StringBuffer sb = new StringBuffer(80);
      sb.append("Game Result(" + getBoardNumber() + "): ")
        .append(getWhitePlayer())
	.append(" vs. ")
	.append(getBlackPlayer())
	.append(" " + getResult());
      return sb.toString();
   }

   public String toString () {
      return getReadable();
   }
}