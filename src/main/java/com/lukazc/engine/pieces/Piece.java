package com.lukazc.engine.pieces;

import com.lukazc.engine.game.Board.Coordinates;
import com.lukazc.engine.game.Move;
import com.lukazc.engine.player.Team;

import java.util.Collection;

public abstract class Piece {
    private final PieceType pieceType;
    private final Team pieceTeam;
    private Coordinates piecePositionTracker;
    private boolean isFirstMove;

    Piece(PieceType pieceType, Team pieceTeam, Coordinates piecePositionTracker) {
        this.pieceType = pieceType;
        this.pieceTeam = pieceTeam;
        this.piecePositionTracker = piecePositionTracker;
        this.isFirstMove = true;
    }

    // PieceType made final to implement in printBoard()

    public final PieceType getPieceType() { return pieceType; }

    public Team getPieceTeam() { return pieceTeam; }

    Coordinates getPiecePositionTracker() {
        return piecePositionTracker;
    }
    public void setPiecePositionTracker(Coordinates newPosition) { this.piecePositionTracker = newPosition; }

    public boolean isFirstMove() {
        return isFirstMove;
    }
    public void registerMove() { if (this.isFirstMove) this.isFirstMove = false; }

    //    Returns a list of coordinates of all tiles this piece can reach.
    public abstract Collection<Move> findLegalMoves();

    public enum PieceType {

        PAWN("P") {
            @Override
            public boolean isPawn() {
                return true;
            }

            @Override
            public boolean isBishop() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isQueen() {
                return false;
            }

            @Override
            public boolean isKnight() {
                return false;
            }
        },
        KNIGHT("N") {
            @Override
            public boolean isPawn() {
                return false;
            }

            @Override
            public boolean isBishop() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isQueen() {
                return false;
            }

            @Override
            public boolean isKnight() {
                return true;
            }
        },
        BISHOP("B") {
            @Override
            public boolean isPawn() {
                return false;
            }

            @Override
            public boolean isBishop() {
                return true;
            }

            @Override
            public boolean isRook() {
                return false;
            }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isQueen() {
                return false;
            }

            @Override
            public boolean isKnight() {
                return false;
            }
        },
        ROOK("R") {
            @Override
            public boolean isPawn() {
                return false;
            }

            @Override
            public boolean isBishop() {
                return false;
            }

            @Override
            public boolean isRook() {
                return true;
            }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isQueen() {
                return false;
            }

            @Override
            public boolean isKnight() {
                return false;
            }
        },
        QUEEN("Q") {
            @Override
            public boolean isPawn() {
                return false;
            }

            @Override
            public boolean isBishop() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isQueen() {
                return true;
            }

            @Override
            public boolean isKnight() {
                return false;
            }
        },
        KING("K") {
            @Override
            public boolean isPawn() {
                return false;
            }

            @Override
            public boolean isBishop() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }

            @Override
            public boolean isKing() {
                return true;
            }

            @Override
            public boolean isQueen() {
                return false;
            }

            @Override
            public boolean isKnight() {
                return false;
            }
        };

        private final String pieceName;

        @Override
        public String toString() {
            return this.pieceName;
        }

        PieceType(final String pieceName) {
            this.pieceName = pieceName;
        }

        public abstract boolean isPawn();
        public abstract boolean isBishop();
        public abstract boolean isRook();
        public abstract boolean isKing();
        public abstract boolean isQueen();
        public abstract boolean isKnight();

    }

}
