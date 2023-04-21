#ifndef MAIN_GAME_SCENSE_H
#define MAIN_GAME_SCENSE_H

#include <QGraphicsScene>
#include <QGraphicsPixmapItem>
#include <QTimer> // Include QTimer header
#include "bucket.h"
#include "cloud.h"

class main_game_scense : public QGraphicsScene
{
    Q_OBJECT
private:
    Bucket *bucket;
    Cloud *cloud;
public:
    main_game_scense();

public slots:
    void spawn_droplet(); // Add a new slot for spawning droplets

};

#endif // MAIN_GAME_SCENSE_H


