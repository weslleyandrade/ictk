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

public class ICSGameCreatedEvent extends ICSEvent 
                                      implements ICSBoardEvent {
   protected static final int GAME_CREATED_EVENT
                = ICSEvent.GAME_CREATED_EVENT;

   //instance/////////////////////////////////////////////////////////////
   protected String white, black;
   protected int boardNumber;
   protected ICSVariant variant;
   protected boolean isRated;
   protected boolean isContinued;

   public ICSGameCreatedEvent () {
      super(GAME_CREATED_EVENT);
   }

   //getters and setters//////////////////////////////////////////////////////
   public String getWhitePlayer () { return white; }
   public void setWhitePlayer (String player) { white = player; }

   public String getBlackPlayer () { return black; }
   public void setBlackPlayer (String player) { black = player; }

   public int getBoardNumber () { return boardNumber; }
   public void setBoardNumber (int board) { boardNumber = board; }

   public ICSVariant getVariant () { return variant; }
   public void setVariant (ICSVariant variant) { this.variant = variant; }

   public boolean isRated () { return isRated; }
   public void setRated (boolean t) { isRated = t; }

   public boolean isContinued () { return isContinued; }
   public void setContinued (boolean t) { isContinued = t; }

   ////////////////////////////////////////////////////////////////////////
   public String getReadable () {
      StringBuffer sb = new StringBuffer(80);
      sb.append("Game Created(" + getBoardNumber() + "): ")
        .append(getWhitePlayer())
	.append(" vs. ")
	.append(getBlackPlayer())
	.append(" ");

      if (!isRated) 
         sb.append("un");

      sb.append("rated ")
        .append(getVariant());

      if (isContinued)
        sb.append(" (continued)");

      return sb.toString();
   }

}
