package cs371m.lifepointcounter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreScreen extends AppCompatActivity {

    private static final String TAG = "ScoreScreen";

    private LifeFrames Game;
    private GraphicsView frame1;
    private GraphicsView frame2;
    private GraphicsView frame3;

    // Buttons
    private Button coinTossButton;
    private Button dieRollButton;
    private Button newGameButton;
    private Button addPlayerButton;
    private Button removePlayerButton;

    // Textviews
    private TextView lifeText1;
    private TextView lifeText2;
    private TextView lifeText3;

    // Icons
    private Bitmap coinBitmap;
    private Bitmap dieBitmap;
    private Bitmap newGameBitmap;

    public void initialize(){
        coinBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.money);
        dieBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon165);
        newGameBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arrows);
    }

    // First Player Frame
    private View.OnTouchListener TouchListener1 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            int yCord = (int) event.getY();
            int height = frame1.getHeight();

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, String.valueOf(yCord), Toast.LENGTH_SHORT);
            toast.show();

            // If the top of the frame is tapped
            if (yCord <= height/2){
                // Because this is player1, small inc up player1
                Game.smallIncUp(0);
                lifeText1.setText(String.valueOf(Game.getPlayerLP(0)));
            }
            else {
                Game.smallIncDown(0);
                lifeText1.setText(String.valueOf(Game.getPlayerLP(0)));
            }


            // So we aren't notified of continued events when finger is moved
            return false;
        }
    };

    // Second Player Frame
    private View.OnTouchListener TouchListener2 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int yCord = (int) event.getY();
            int height = frame2.getHeight();

//            Context context = getApplicationContext();
//            Toast toast = Toast.makeText(context, String.valueOf(yCord), Toast.LENGTH_SHORT);
//            toast.show();

            // If the top of the frame is tapped
            if (yCord <= height/2){

                Context context2 = getApplicationContext();
                Toast toast2 = Toast.makeText(context2, "Entered Y Coord <= y/2", Toast.LENGTH_SHORT);
                toast2.show();

                // Because this is player2, small inc up player2
                Game.smallIncUp(1);
                lifeText2.setText(String.valueOf(Game.getPlayerLP(1)));
            }
            else {
                Game.smallIncDown(1);
                lifeText2.setText(String.valueOf(Game.getPlayerLP(1)));
            }

            // So we aren't notified of continued events when finger is moved
            return false;
        }
    };

    // Third player frame
    private View.OnTouchListener TouchListener3 = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int yCord = (int) event.getY();
            int height = frame3.getHeight();

//            Context context = getApplicationContext();
//            Toast toast = Toast.makeText(context, String.valueOf(yCord), Toast.LENGTH_SHORT);
//            toast.show();

            // If the top of the frame is tapped
            if (yCord <= height/2){

//                Context context2 = getApplicationContext();
//                Toast toast2 = Toast.makeText(context2, "Entered Y Coord <= y/2", Toast.LENGTH_SHORT);
//                toast2.show();

                // Because this is player2, small inc up player2
                Game.smallIncUp(2);
                lifeText3.setText(String.valueOf(Game.getPlayerLP(2)));
            }
            else {
                Game.smallIncDown(2);
                lifeText3.setText(String.valueOf(Game.getPlayerLP(2)));
            }

            // So we aren't notified of continued events when finger is moved
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Starting this content view at scorescreen3 works, but moving from there doesn't
        setContentView(R.layout.scorescreen3);

        Log.d(TAG, "in onCreate Method");

        // Initialize toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        coinTossButton = (Button) findViewById(R.id.coin_button);
        dieRollButton = (Button) findViewById(R.id.die_button);
        newGameButton = (Button) findViewById(R.id.new_game_button);
        addPlayerButton = (Button) findViewById(R.id.add_player);
        removePlayerButton = (Button) findViewById(R.id.remove_player);

        // Text inside life frames
        lifeText1 = (TextView) findViewById(R.id.player1LifeText);
        lifeText2 = (TextView) findViewById(R.id.player2LifeText);
        lifeText3 = (TextView) findViewById(R.id.player3LifeText);

        // Black rectangle frames
        frame1 = (GraphicsView) findViewById(R.id.graphicsView);
        frame2 = (GraphicsView) findViewById(R.id.graphicsView2);
        frame3 = (GraphicsView) findViewById(R.id.graphicsView3);
        frame1.setOnTouchListener(TouchListener1);
        frame2.setOnTouchListener(TouchListener2);
        frame3.setOnTouchListener(TouchListener3);

        Game = new LifeFrames();

    } // END OF ON CREATE

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "in onResume Method");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "in onRestart Method");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "in onPause Method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "in onStop Method");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "in onDestroy");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_score_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(ScoreScreen.this, Settings.class);
            //ScoreScreen.this.startActivity(intent);
            ScoreScreen.this.startActivityForResult(intent, 1);
            //ScoreScreen.this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Everything that needs to happen for a new game to start
    public void startNewGame(View newGameButton){
        Game.newGame();

        // Set the textview numbers back to starting life
        // Make sure the line below works with integers
        lifeText1.setText(String.valueOf(Game.startingLifeTotal));
        lifeText2.setText(String.valueOf(Game.startingLifeTotal));
        lifeText3.setText(String.valueOf(Game.startingLifeTotal));

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "New Game Started", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void tossCoin(View coinTossButton) {

        Context context = getApplicationContext();
        CharSequence heads = "Coin landed on Heads!";
        CharSequence tails = "Coin landed on Tails!";
        int duration = Toast.LENGTH_SHORT;

        if (Game.tossCoin()) {
            Toast toast = Toast.makeText(context, heads, duration);
            toast.show();
        } else {
            Toast toast = Toast.makeText(context, tails, duration);
            toast.show();
        }
    }

    public void rollDie(View dieRollButton){

        Context context = getApplicationContext();
        // For now, the default will be to roll a six sided die
        int roll = Game.rollDie(6);
        String results = "Die result is ";
        results = results.concat(String.valueOf(roll));
        Toast toast = Toast.makeText(context, results, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void addPlayer(View addPlayerButton){

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Coming Soon!!", Toast.LENGTH_SHORT);
        toast.show();

        // Needs logic here that checks what view we're currently using?
        setContentView(R.layout.scorescreen3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lifeText1 = (TextView) findViewById(R.id.player1LifeText);
        lifeText2 = (TextView) findViewById(R.id.player2LifeText);
        lifeText3 = (TextView) findViewById(R.id.player3LifeText);

        frame1 = (GraphicsView) findViewById(R.id.graphicsView);
        frame2 = (GraphicsView) findViewById(R.id.graphicsView2);
        frame3 = (GraphicsView) findViewById(R.id.graphicsView3);

//        Log.d(TAG, "Went through all the other motions");
    }

    public void removePlayer(View removePlayerButton){

        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Coming Soon!!", Toast.LENGTH_SHORT);
        toast.show();

        // Needs logic here that checks what view we're currently using?
        setContentView(R.layout.scorescreen);

        // Initialize toolbar /* HAS TO BE HERE! */
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // The buttons don't seem to have to be reassigned
//        coinTossButton = (Button) findViewById(R.id.coin_button);
//        dieRollButton = (Button) findViewById(R.id.die_button);
//        newGameButton = (Button) findViewById(R.id.new_game_button);
//        addPlayerButton = (Button) findViewById(R.id.add_player);
//        removePlayerButton = (Button) findViewById(R.id.remove_player);

        // Text inside life frames
        lifeText1 = (TextView) findViewById(R.id.player1LifeText);
        lifeText2 = (TextView) findViewById(R.id.player2LifeText);
//        lifeText3 = (TextView) findViewById(R.id.player3LifeText);

        // Black rectangle frames
        frame1 = (GraphicsView) findViewById(R.id.graphicsView);
        frame2 = (GraphicsView) findViewById(R.id.graphicsView2);
//        frame3 = (GraphicsView) findViewById(R.id.graphicsView3);
//        frame1.setOnTouchListener(TouchListener1);
//        frame2.setOnTouchListener(TouchListener2);

        // This would basically reset the game, don't need to do that.
//        Game = new LifeFrames();
//        Log.d(TAG, "Went through the motions");
    }
}

// WAS AT END OF ONCREATE()
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });