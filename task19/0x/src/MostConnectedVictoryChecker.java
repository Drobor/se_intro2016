import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by m295- on 19.11.2016.
 */
public class MostConnectedVictoryChecker implements IVictoryChecker {
    public GameState check(IField field) {
        if (field.hasEmpty())
            return new GameState(false);
        boolean[][] visited = new boolean[field.getSizeX()][field.getSizeY()];
        boolean isDraw = true;
        int maxBlock = -1;
        int maxBlockX = 0;
        int maxBlockY = 0;
        for (int x = 0; x < field.getSizeX(); x++)
            for (int y = 0; y < field.getSizeY(); y++) {
                int curBlock = dfs(field, x, y, field.get(x, y), visited);
                if (maxBlock == curBlock) {
                    isDraw = true;
                } else if (maxBlock < curBlock) {
                    isDraw = false;
                    maxBlock = curBlock;
                    maxBlockX = x;
                    maxBlockY = y;
                }
            }
        if (isDraw)
            return new GameState(true);
        else
            return new GameState(field.get(maxBlockX, maxBlockY));
    }

    int dfs(IField field, int x, int y, Player curPlayer, boolean[][] visited) {
        if (!(field.get(x, y) == curPlayer) || visited[x][y])
            return 0;
        visited[x][y] = true;
        int returns = 1;
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                returns += tryDFS(field, x + dx, y + dy, curPlayer, visited);
        return returns;
    }

    int tryDFS(IField field, int x, int y, Player curPlayer, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= field.getSizeX() || y >= field.getSizeY())
            return 0;
        return dfs(field, x, y, curPlayer, visited);
    }
}
