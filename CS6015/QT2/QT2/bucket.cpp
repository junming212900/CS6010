#include "bucket.h"
#include <QGraphicsScene>
#include <QKeyEvent>

Bucket::Bucket()
{
    setPixmap(QPixmap(":/images/bucket.png").scaled(150, 150)); // Set the image for the bucket
    setPos(400, 365); // Set the initial position of the bucket
}

void Bucket::keyPressEvent(QKeyEvent *event)
{
    if (event->key() == Qt::Key_Left)
    {
        if (x() > 0)
        {
            setPos(x() - 10, y());
        }
    }
    else if (event->key() == Qt::Key_Right)
    {
        if (x() + pixmap().width() < scene()->width())
        {
            setPos(x() + 10, y());
        }
    }
}
