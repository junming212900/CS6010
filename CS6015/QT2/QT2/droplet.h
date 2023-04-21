#ifndef DROPLET_H
#define DROPLET_H

#include <QObject>
#include <QGraphicsPixmapItem>
#include <QTimer>

class Droplet : public QObject, public QGraphicsPixmapItem
{
    Q_OBJECT
public:
    Droplet();

public slots:
    void move_droplet(); // Declare the move_droplet slot
};

#endif // DROPLET_H
