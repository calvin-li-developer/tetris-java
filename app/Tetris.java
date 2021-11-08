package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Tetris extends Application {
	// The variables
	public static final int MOVE = 25;
	public static final int SIZE = 25;
	public static int XMAX = SIZE * 12;
	public static int YMAX = SIZE * 24;
	public static int[][] GRID = new int[XMAX / SIZE][YMAX / SIZE];
	private static Pane group = new Pane();
	private static Form object;
	private static Scene scene = new Scene(group, XMAX + 150, YMAX);
	public static int score = 0;
	private static int top = 0;
	private static boolean game = true;
	private static Form nextObj = Controller.makeRect();
	private static int lineNum = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		for (int[] a : GRID) {
			Arrays.fill(a, 0);
		}

		Line linex1 = new Line(XMAX - 0 * SIZE, 0, XMAX - 0 * SIZE, YMAX);
		Line linex2 = new Line(XMAX - 1 * SIZE, 0, XMAX - 1 * SIZE, YMAX);
		Line linex3 = new Line(XMAX - 2 * SIZE, 0, XMAX - 2 * SIZE, YMAX);
		Line linex4 = new Line(XMAX - 3 * SIZE, 0, XMAX - 3 * SIZE, YMAX);
		Line linex5 = new Line(XMAX - 4 * SIZE, 0, XMAX - 4 * SIZE, YMAX);
		Line linex6 = new Line(XMAX - 5 * SIZE, 0, XMAX - 5 * SIZE, YMAX);
		Line linex7 = new Line(XMAX - 6 * SIZE, 0, XMAX - 6 * SIZE, YMAX);
		Line linex8 = new Line(XMAX - 7 * SIZE, 0, XMAX - 7 * SIZE, YMAX);
		Line linex9 = new Line(XMAX - 8 * SIZE, 0, XMAX - 8 * SIZE, YMAX);
		Line linex10 = new Line(XMAX - 9 * SIZE, 0, XMAX - 9 * SIZE, YMAX);
		Line linex11 = new Line(XMAX - 10 * SIZE, 0, XMAX - 10 * SIZE, YMAX);
		Line linex12 = new Line(XMAX - 11 * SIZE, 0, XMAX - 11 * SIZE, YMAX);
		Line linex13 = new Line(XMAX - 12 * SIZE, 0, XMAX - 12 * SIZE, YMAX);

		Line liney1 = new Line(0, 1 * SIZE, XMAX - 0 * SIZE, 1 * SIZE);
		Line liney2 = new Line(0, 2 * SIZE, XMAX - 0 * SIZE, 2 * SIZE);
		Line liney3 = new Line(0, 3 * SIZE, XMAX - 0 * SIZE, 3 * SIZE);
		Line liney4 = new Line(0, 4 * SIZE, XMAX - 0 * SIZE, 4 * SIZE);
		Line liney5 = new Line(0, 5 * SIZE, XMAX - 0 * SIZE, 5 * SIZE);
		Line liney6 = new Line(0, 6 * SIZE, XMAX - 0 * SIZE, 6 * SIZE);
		Line liney7 = new Line(0, 7 * SIZE, XMAX - 0 * SIZE, 7 * SIZE);
		Line liney8 = new Line(0, 8 * SIZE, XMAX - 0 * SIZE, 8 * SIZE);
		Line liney9 = new Line(0, 9 * SIZE, XMAX - 0 * SIZE, 9 * SIZE);
		Line liney10 = new Line(0, 10 * SIZE, XMAX - 0 * SIZE, 10 * SIZE);
		Line liney11 = new Line(0, 11 * SIZE, XMAX - 0 * SIZE, 11 * SIZE);
		Line liney12 = new Line(0, 12 * SIZE, XMAX - 0 * SIZE, 12 * SIZE);
		Line liney13 = new Line(0, 13 * SIZE, XMAX - 0 * SIZE, 13 * SIZE);
		Line liney14 = new Line(0, 14 * SIZE, XMAX - 0 * SIZE, 14 * SIZE);
		Line liney15 = new Line(0, 15 * SIZE, XMAX - 0 * SIZE, 15 * SIZE);
		Line liney16 = new Line(0, 16 * SIZE, XMAX - 0 * SIZE, 16 * SIZE);
		Line liney17 = new Line(0, 17 * SIZE, XMAX - 0 * SIZE, 17 * SIZE);
		Line liney18 = new Line(0, 18 * SIZE, XMAX - 0 * SIZE, 18 * SIZE);
		Line liney19 = new Line(0, 19 * SIZE, XMAX - 0 * SIZE, 19 * SIZE);
		Line liney20 = new Line(0, 20 * SIZE, XMAX - 0 * SIZE, 20 * SIZE);
		Line liney21 = new Line(0, 21 * SIZE, XMAX - 0 * SIZE, 21 * SIZE);
		Line liney22 = new Line(0, 22 * SIZE, XMAX - 0 * SIZE, 22 * SIZE);
		Line liney23 = new Line(0, 23 * SIZE, XMAX - 0 * SIZE, 23 * SIZE);

		linex1.setStroke(Color.WHITE);
		linex2.setStroke(Color.WHITE);
		linex3.setStroke(Color.WHITE);
		linex4.setStroke(Color.WHITE);
		linex5.setStroke(Color.WHITE);
		linex6.setStroke(Color.WHITE);
		linex7.setStroke(Color.WHITE);
		linex8.setStroke(Color.WHITE);
		linex9.setStroke(Color.WHITE);
		linex10.setStroke(Color.WHITE);
		linex11.setStroke(Color.WHITE);
		linex12.setStroke(Color.WHITE);
		linex13.setStroke(Color.WHITE);
		liney1.setStroke(Color.WHITE);
		liney2.setStroke(Color.WHITE);
		liney3.setStroke(Color.WHITE);
		liney4.setStroke(Color.WHITE);
		liney5.setStroke(Color.WHITE);
		liney6.setStroke(Color.WHITE);
		liney7.setStroke(Color.WHITE);
		liney8.setStroke(Color.WHITE);
		liney9.setStroke(Color.WHITE);
		liney10.setStroke(Color.WHITE);
		liney11.setStroke(Color.WHITE);
		liney12.setStroke(Color.WHITE);
		liney13.setStroke(Color.WHITE);
		liney14.setStroke(Color.WHITE);
		liney15.setStroke(Color.WHITE);
		liney16.setStroke(Color.WHITE);
		liney17.setStroke(Color.WHITE);
		liney18.setStroke(Color.WHITE);
		liney19.setStroke(Color.WHITE);
		liney20.setStroke(Color.WHITE);
		liney21.setStroke(Color.WHITE);
		liney22.setStroke(Color.WHITE);
		liney23.setStroke(Color.WHITE);

		Text scoretext = new Text("Score: ");
		scoretext.setStyle("-fx-font: 20 arial;");
		scoretext.setY(50);
		scoretext.setX(XMAX + SIZE);
		scoretext.setFill(Color.WHITE);
		Text level = new Text("Lines: ");
		level.setStyle("-fx-font: 20 arial;");
		level.setY(100);
		level.setX(XMAX + SIZE);
		level.setFill(Color.WHITE);
		group.getChildren().addAll(scoretext, linex1, linex2, linex3, linex4, linex5, linex6, linex7, linex8, linex9,
				linex10, linex11, linex12, linex13, liney1, liney2, liney3, liney4, liney5, liney6, liney7, liney8,
				liney9, liney10, liney11, liney12, liney13, liney14, liney15, liney16, liney17, liney18, liney19,
				liney20, liney21, liney22, liney23, level);
		Form a = nextObj;
		group.getChildren().addAll(a.a, a.b, a.c, a.d);
		moveOnKeyPress(a);
		object = a;
		nextObj = Controller.makeRect();
		scene.setFill(Color.BLACK);
		stage.setScene(scene);
		stage.setTitle("TETRIS");
		stage.show();

		Timer fall = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					public void run() {
						if (object.a.getY() == 0 || object.b.getY() == 0 || object.c.getY() == 0
								|| object.d.getY() == 0)
							top++;
						else
							top = 0;

						if (top == 2) {
							// GAME OVER
							Text over = new Text("GAME OVER");
							over.setFill(Color.RED);
							over.setStyle("-fx-font: 70 arial;");
							over.setY(250);
							over.setX(10);
							group.getChildren().add(over);
							game = false;
						}
						// Exit
						if (top == 15) {
							System.exit(0);
						}

						if (game) {
							MoveDown(object);
							scoretext.setText("Score: " + Integer.toString(score));
							level.setText("Lines: " + Integer.toString(lineNum));
						}
					}
				});
			}
		};
		fall.schedule(task, 0, 300);
	}

	@FXML
	public void exitApplication(ActionEvent event) {
		Platform.exit();
		System.exit(0);
	}

	@Override
	public void stop() {
		Platform.exit();
		System.exit(0);
	}

	private void moveOnKeyPress(Form form) {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case RIGHT:
					Controller.MoveRight(form);
					break;
				case DOWN:
					MoveDown(form);
					score++;
					break;
				case LEFT:
					Controller.MoveLeft(form);
					break;
				case UP:
					MoveTurn(form);
					break;
				}
			}
		});
	}

	private void MoveTurn(Form form) {
		int f = form.form;
		Rectangle a = form.a;
		Rectangle b = form.b;
		Rectangle c = form.c;
		Rectangle d = form.d;
		switch (form.getName()) {
		case "j":
			if (f == 1 && cB(a, 1, -1) && cB(c, -1, -1) && cB(d, -2, -2)) {
				MoveRight(form.a);
				MoveDown(form.a);
				MoveDown(form.c);
				MoveLeft(form.c);
				MoveDown(form.d);
				MoveDown(form.d);
				MoveLeft(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, -2, 2)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveLeft(form.d);
				MoveLeft(form.d);
				MoveUp(form.d);
				MoveUp(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, 1) && cB(c, 1, 1) && cB(d, 2, 2)) {
				MoveLeft(form.a);
				MoveUp(form.a);
				MoveUp(form.c);
				MoveRight(form.c);
				MoveUp(form.d);
				MoveUp(form.d);
				MoveRight(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 2, -2)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveRight(form.d);
				MoveRight(form.d);
				MoveDown(form.d);
				MoveDown(form.d);
				form.changeForm();
				break;
			}
			break;
		case "l":
			if (f == 1 && cB(a, 1, -1) && cB(c, 1, 1) && cB(b, 2, 2)) {
				MoveRight(form.a);
				MoveDown(form.a);
				MoveUp(form.c);
				MoveRight(form.c);
				MoveUp(form.b);
				MoveUp(form.b);
				MoveRight(form.b);
				MoveRight(form.b);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -1, -1) && cB(b, 2, -2) && cB(c, 1, -1)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveRight(form.b);
				MoveRight(form.b);
				MoveDown(form.b);
				MoveDown(form.b);
				MoveRight(form.c);
				MoveDown(form.c);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, 1) && cB(c, -1, -1) && cB(b, -2, -2)) {
				MoveLeft(form.a);
				MoveUp(form.a);
				MoveDown(form.c);
				MoveLeft(form.c);
				MoveDown(form.b);
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveLeft(form.b);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(b, -2, 2) && cB(c, -1, 1)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveLeft(form.b);
				MoveLeft(form.b);
				MoveUp(form.b);
				MoveUp(form.b);
				MoveLeft(form.c);
				MoveUp(form.c);
				form.changeForm();
				break;
			}
			break;
		case "o":
			break;
		case "s":
			if (f == 1 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveUp(form.d);
				MoveUp(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveDown(form.d);
				MoveDown(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, -1) && cB(c, -1, 1) && cB(d, 0, 2)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveUp(form.d);
				MoveUp(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, 1, 1) && cB(c, 1, -1) && cB(d, 0, -2)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveDown(form.d);
				MoveDown(form.d);
				form.changeForm();
				break;
			}
			break;
		case "t":
			if (f == 1 && cB(a, 1, 1) && cB(d, -1, -1) && cB(c, -1, 1)) {
				MoveUp(form.a);
				MoveRight(form.a);
				MoveDown(form.d);
				MoveLeft(form.d);
				MoveLeft(form.c);
				MoveUp(form.c);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, 1, -1) && cB(d, -1, 1) && cB(c, 1, 1)) {
				MoveRight(form.a);
				MoveDown(form.a);
				MoveLeft(form.d);
				MoveUp(form.d);
				MoveUp(form.c);
				MoveRight(form.c);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, -1, -1) && cB(d, 1, 1) && cB(c, 1, -1)) {
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveUp(form.d);
				MoveRight(form.d);
				MoveRight(form.c);
				MoveDown(form.c);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, -1, 1) && cB(d, 1, -1) && cB(c, -1, -1)) {
				MoveLeft(form.a);
				MoveUp(form.a);
				MoveRight(form.d);
				MoveDown(form.d);
				MoveDown(form.c);
				MoveLeft(form.c);
				form.changeForm();
				break;
			}
			break;
		case "z":
			if (f == 1 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
				MoveUp(form.b);
				MoveRight(form.b);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveLeft(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveRight(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(b, 1, 1) && cB(c, -1, 1) && cB(d, -2, 0)) {
				MoveUp(form.b);
				MoveRight(form.b);
				MoveLeft(form.c);
				MoveUp(form.c);
				MoveLeft(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(b, -1, -1) && cB(c, 1, -1) && cB(d, 2, 0)) {
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveRight(form.c);
				MoveDown(form.c);
				MoveRight(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			break;
		case "i":
			if (f == 1 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
				MoveUp(form.a);
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.a);
				MoveUp(form.b);
				MoveRight(form.b);
				MoveDown(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 2 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
				MoveDown(form.a);
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.a);
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveUp(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			if (f == 3 && cB(a, 2, 2) && cB(b, 1, 1) && cB(d, -1, -1)) {
				MoveUp(form.a);
				MoveUp(form.a);
				MoveRight(form.a);
				MoveRight(form.a);
				MoveUp(form.b);
				MoveRight(form.b);
				MoveDown(form.d);
				MoveLeft(form.d);
				form.changeForm();
				break;
			}
			if (f == 4 && cB(a, -2, -2) && cB(b, -1, -1) && cB(d, 1, 1)) {
				MoveDown(form.a);
				MoveDown(form.a);
				MoveLeft(form.a);
				MoveLeft(form.a);
				MoveDown(form.b);
				MoveLeft(form.b);
				MoveUp(form.d);
				MoveRight(form.d);
				form.changeForm();
				break;
			}
			break;
		}
	}

	private void RemoveRows(Pane pane) {
		ArrayList<Node> rects = new ArrayList<Node>();
		ArrayList<Integer> lines = new ArrayList<Integer>();
		ArrayList<Node> newrects = new ArrayList<Node>();
		int full = 0;
		for (int i = 0; i < GRID[0].length; i++) {
			for (int j = 0; j < GRID.length; j++) {
				if (GRID[j][i] == 1)
					full++;
			}
			if (full == GRID.length)
				lines.add(i);

			full = 0;
		}
		if (lines.size() > 0)
			do {
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				score += 50;
				lineNum++;

				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() == lines.get(0) * SIZE) {
						GRID[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						pane.getChildren().remove(node);
					} else
						newrects.add(node);
				}

				for (Node node : newrects) {
					Rectangle a = (Rectangle) node;
					if (a.getY() < lines.get(0) * SIZE) {
						GRID[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 0;
						a.setY(a.getY() + SIZE);
					}
				}
				lines.remove(0);
				rects.clear();
				newrects.clear();
				for (Node node : pane.getChildren()) {
					if (node instanceof Rectangle)
						rects.add(node);
				}
				for (Node node : rects) {
					Rectangle a = (Rectangle) node;
					try {
						GRID[(int) a.getX() / SIZE][(int) a.getY() / SIZE] = 1;
					} catch (ArrayIndexOutOfBoundsException e) {
					}
				}
				rects.clear();
			} while (lines.size() > 0);
	}

	private void MoveDown(Rectangle rect) {
		if (rect.getY() + MOVE < YMAX)
			rect.setY(rect.getY() + MOVE);

	}

	private void MoveRight(Rectangle rect) {
		if (rect.getX() + MOVE <= XMAX - SIZE)
			rect.setX(rect.getX() + MOVE);
	}

	private void MoveLeft(Rectangle rect) {
		if (rect.getX() - MOVE >= 0)
			rect.setX(rect.getX() - MOVE);
	}

	private void MoveUp(Rectangle rect) {
		if (rect.getY() - MOVE > 0)
			rect.setY(rect.getY() - MOVE);
	}

	private void MoveDown(Form form) {
		if (form.a.getY() == YMAX - SIZE || form.b.getY() == YMAX - SIZE || form.c.getY() == YMAX - SIZE
				|| form.d.getY() == YMAX - SIZE || moveA(form) || moveB(form) || moveC(form) || moveD(form)) {
			GRID[(int) form.a.getX() / SIZE][(int) form.a.getY() / SIZE] = 1;
			GRID[(int) form.b.getX() / SIZE][(int) form.b.getY() / SIZE] = 1;
			GRID[(int) form.c.getX() / SIZE][(int) form.c.getY() / SIZE] = 1;
			GRID[(int) form.d.getX() / SIZE][(int) form.d.getY() / SIZE] = 1;
			RemoveRows(group);

			Form a = nextObj;
			nextObj = Controller.makeRect();
			object = a;
			group.getChildren().addAll(a.a, a.b, a.c, a.d);
			moveOnKeyPress(a);
		}

		if (form.a.getY() + MOVE < YMAX && form.b.getY() + MOVE < YMAX && form.c.getY() + MOVE < YMAX
				&& form.d.getY() + MOVE < YMAX) {
			int movea = GRID[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1];
			int moveb = GRID[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1];
			int movec = GRID[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1];
			int moved = GRID[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1];
			if (movea == 0 && movea == moveb && moveb == movec && movec == moved) {
				form.a.setY(form.a.getY() + MOVE);
				form.b.setY(form.b.getY() + MOVE);
				form.c.setY(form.c.getY() + MOVE);
				form.d.setY(form.d.getY() + MOVE);
			}
		}
	}

	private boolean moveA(Form form) {
		return (GRID[(int) form.a.getX() / SIZE][((int) form.a.getY() / SIZE) + 1] == 1);
	}

	private boolean moveB(Form form) {
		return (GRID[(int) form.b.getX() / SIZE][((int) form.b.getY() / SIZE) + 1] == 1);
	}

	private boolean moveC(Form form) {
		return (GRID[(int) form.c.getX() / SIZE][((int) form.c.getY() / SIZE) + 1] == 1);
	}

	private boolean moveD(Form form) {
		return (GRID[(int) form.d.getX() / SIZE][((int) form.d.getY() / SIZE) + 1] == 1);
	}

	private boolean cB(Rectangle rect, int x, int y) {
		boolean xb = false;
		boolean yb = false;
		if (x >= 0)
			xb = rect.getX() + x * MOVE <= XMAX - SIZE;
		if (x < 0)
			xb = rect.getX() + x * MOVE >= 0;
		if (y >= 0)
			yb = rect.getY() - y * MOVE > 0;
		if (y < 0)
			yb = rect.getY() + y * MOVE < YMAX;
		return xb && yb && GRID[((int) rect.getX() / SIZE) + x][((int) rect.getY() / SIZE) - y] == 0;
	}

}
