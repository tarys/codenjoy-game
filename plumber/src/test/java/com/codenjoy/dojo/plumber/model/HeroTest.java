package com.codenjoy.dojo.plumber.model;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 - 2018 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.codenjoy.dojo.plumber.model.items.Pipe;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.codenjoy.dojo.plumber.model.items.Pipe.Builder.getTypeMapping;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HeroTest {
    @Mock
    private Field fieldMock;

    private ArgumentCaptor<Pipe> captor = ArgumentCaptor.forClass(Pipe.class);

    @Test
    public void pipeActuallyAddedWhenActCalled() {
        // given
        Hero hero = new Hero();
        int x = 1;
        int y = 2;
        int code = 0;
        Elements pipeType = getTypeMapping().get(code);

        // when
        hero.init(fieldMock);
        hero.act(code, x, y);

        // then
        verify(fieldMock).addPipe(captor.capture());
        Pipe addedPipe = captor.getValue();
        assertEquals(pipeType, addedPipe.state(null, (Object[]) null));
        assertEquals(x, addedPipe.getX());
        assertEquals(y, addedPipe.getY());
    }
}