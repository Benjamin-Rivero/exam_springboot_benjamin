package fr.benjamin.exam_springboot_benjamin.event_listener;

import fr.poec.springboot.instant_faking.entity.interfaces.SluggerInterface;
import fr.poec.springboot.instant_faking.utils.Slugger;
import lombok.AllArgsConstructor;
import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SluggerEventListener implements PreInsertEventListener,
                                             PreUpdateEventListener
{

    private Slugger slugger;

    @Override
    public boolean onPreInsert(PreInsertEvent preInsertEvent) {
        return hasSlugify(preInsertEvent.getEntity());
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent preUpdateEvent) {
        return hasSlugify(preUpdateEvent.getEntity());
    }

    private boolean hasSlugify(Object o) {
        if (o instanceof SluggerInterface si) {
            if (si.getField() == null) {
                return true;
            }
            si.setSlug(slugger.slugify(si.getField()));
        }
        return false;
    }

}
