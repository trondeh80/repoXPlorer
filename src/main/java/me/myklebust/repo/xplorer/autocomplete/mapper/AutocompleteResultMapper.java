package me.myklebust.repo.xplorer.autocomplete.mapper;

import me.myklebust.repo.xplorer.autocomplete.AutocompleteResult;

import com.enonic.xp.script.serializer.MapGenerator;
import com.enonic.xp.script.serializer.MapSerializable;

public class AutocompleteResultMapper
    implements MapSerializable
{

    private final AutocompleteResult result;

    public AutocompleteResultMapper( final AutocompleteResult result )
    {
        this.result = result;
    }

    @Override
    public void serialize( final MapGenerator gen )
    {
        gen.value( "valid", result.isValid() );
    }
}