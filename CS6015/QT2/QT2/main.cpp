#include <QApplication>
#include <QGraphicsPixmapItem>
#include <QGraphicsScene>
#include <QGraphicsView>
#include "main_game_scense.h"
#include <ctime>

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);

    srand(time(0)); // Seed the random number generator

    main_game_scense *main_scene = new main_game_scense();

    QGraphicsView *main_view = new QGraphicsView();
    main_view->setScene(main_scene);
    main_view->setFixedSize(910, 512);
    main_view->setHorizontalScrollBarPolicy(Qt::ScrollBarAlwaysOff);
    main_view->setVerticalScrollBarPolicy(Qt::ScrollBarAlwaysOff);
    main_view->show();

    return app.exec();
}
