package me.myklebust.repo.xplorer.autocomplete.producers;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.google.common.collect.Lists;

import me.myklebust.repo.xplorer.autocomplete.SuggestionProducer;
import me.myklebust.repo.xplorer.autocomplete.context.ProducerContext;

@Component(immediate = true)
public class SuggestionProducersImpl
    implements SuggestionProducers
{
    private final List<SuggestionProducer> producerList = Lists.newArrayList();

    @Override
    public List<String> match( final String term, final ProducerContext context )
    {
        List<String> suggestions = Lists.newArrayList();

        producerList.forEach( ( producer ) -> {
            suggestions.addAll( producer.produce( term, context ) );
        } );

        return suggestions;
    }

    @Reference(cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    public void register( final SuggestionProducer producer )
    {
        this.producerList.add( producer );
    }

}
