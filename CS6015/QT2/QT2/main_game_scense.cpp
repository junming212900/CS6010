#include "main_game_scense.h"
#include "droplet.h" // Include Droplet header
#include <cstdlib>
#include <ctime>

main_game_scense::main_game_scense()
{
    setBackgroundBrush(QBrush(QImage(":/images/background.jpg").scaledToHeight(512).scaledToWidth(910)));
    setSceneRect(0, 0, 908, 510);

    bucket = new Bucket();
    addItem(bucket);

    bucket->setFlag(QGraphicsItem::ItemIsFocusable);
    bucket->setFocus();

    // Create a QTimer object for spawning droplets
    QTimer *droplet_timer = new QTimer(this);
    connect(droplet_timer, &QTimer::timeout, this, &main_game_scense::spawn_droplet);
    droplet_timer->start(2000); // Set the interval for spawning droplets (in milliseconds)

    cloud = new Cloud();
    cloud->setPos(0, 0);
    addItem(cloud);
}

void main_game_scense::spawn_droplet()
{
    // Create a new Droplet object
    Droplet *droplet = new Droplet();

    // Set the initial position of the droplet
    droplet->setPos(rand() % (int)sceneRect().width(), 0);

    // Add the droplet to the scene
    addItem(droplet);
}


