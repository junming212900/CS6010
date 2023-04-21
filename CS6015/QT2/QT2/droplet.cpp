#include "droplet.h"
#include "bucket.h" // Include the header for the Bucket class
#include <QGraphicsScene>

Droplet::Droplet()
{
    setPixmap(QPixmap(":/images/water.gif").scaled(30, 30));

    QTimer *timer_drop = new QTimer(this);
    connect(timer_drop, &QTimer::timeout, this, &Droplet::move_droplet);
    timer_drop->start(50);
}

void Droplet::move_droplet()
{
    setPos(x(), y() + 10);

    QList<QGraphicsItem *> colliding_items = collidingItems();
    for (int i = 0; i < colliding_items.size(); ++i)
    {
        if (typeid(*(colliding_items[i])) == typeid(Bucket) || typeid(*(colliding_items[i])) == typeid(Droplet))
        {
            scene()->removeItem(this);
            delete this;
            return;
        }
    }

    if (y() > 510)
    {
        scene()->removeItem(this);
        delete this;
    }
}
