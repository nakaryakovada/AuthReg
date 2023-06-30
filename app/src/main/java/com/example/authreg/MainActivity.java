package com.example.authreg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int start_x = 0; // координатAа X при нажатии
    int end_x = 0; // координата X при отпуске

    @Override
    //Функция определения свайпа
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) { // определение метода
            case MotionEvent.ACTION_UP: // если нажатие
                start_x = (int) event.getX(); // определяем координату X
                break; // конец
            case MotionEvent.ACTION_DOWN: // если отжатие
                end_x = (int) event.getX(); // определяем координату X
                break;
        }

        if (start_x != 0 && end_x != 0) { // если координаты не 0
            if (start_x > end_x) { // если начальная координата больше комечной
                // свайп влево
                setContentView(R.layout.activity_main); // мекяем экран
            } else if (start_x < end_x) { // если начельная координата меньше последней
                // свайп вправо
                setContentView(R.layout.activity_reg); // меняем экран
            }

            start_x = 0; // сбнуляем координаты
            end_x = 0; // обнуляем координаты
            return false;
        }
        return false;
    }
}