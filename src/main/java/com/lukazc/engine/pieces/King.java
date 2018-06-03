package com.lukazc.engine.pieces;

import com.lukazc.engine.game.Board;
import com.lukazc.engine.player.Team;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class King extends Piece {
    public King(PieceType pieceType, Team pieceTeam, Board.Coordinates piecePosition) {
        super(pieceType, pieceTeam, piecePosition);
    }

    /**
     * Check board diagonally in 4 directions. Collect coordinates of empty tiles to a Set.
     * Stop when a Piece is found. If it's an enemy piece, store its coordinates too.
     */
    @Override
    public Collection<Board.Coordinates> findLegalMoves(Board board) {
        Set<Board.Coordinates> legalMoves = new HashSet<>();

        Board.Coordinates startPosition = this.getPiecePositionTracker();
        int x = startPosition.getX();
        int y = startPosition.getY();

        int xMod = 1;
        int yMod = 1;

        Map boardState = board.getBoardState();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (inBoardBounds(x + i, y + j)) {
                    Board.Coordinates coordinates = new Board.Coordinates(x + i,y + j);
                    Piece piece = (Piece) boardState.get(coordinates);

                    // If empty tile, add to legalMoves.
                    if (piece == null) {
                        legalMoves.add(coordinates);
                    }
                    // If there's a piece on the tile,
                    // and it's the enemy, but not the King,
                    // add to legalMoves.
                    if (piece != null) {
                        if (piece.getPieceTeam() != this.getPieceTeam()
                                && piece.getPieceType() != PieceType.KING) {
                            legalMoves.add(coordinates);
                        }
                    }
                }
            }
            } return legalMoves;
        }
}
