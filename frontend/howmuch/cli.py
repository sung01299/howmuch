import click
import json
import os
import api

def authenticate():
    """Handle user authentication (login/register) once."""
    user_name = click.prompt("Please enter your user name to login or register", type=str)
    response = api.check_if_user_exists(user_name)
    user_id = response.get('userId')
    user_exists = response.get('exist')
    if not user_exists:
        register_user = click.confirm(f'User "{user_name}" does not exist. Would you like to register?', default=True)
        if register_user:
            user_created = api.register_user(user_name)
            user_id = user_created.get('userId')
            if user_created:
                click.echo(f'User "{user_name}" registered successfully.')
                click.echo(f'Welcome, {user_name}!')
            else:
                click.echo(f'Failed to register user "{user_name}". Exiting.')
                exit()
        else:
            exit()
    else:
        click.echo(f'Welcome, {user_name}!')

    return user_id

@click.group()
def cli():
    """Base CLI group."""
    pass

@cli.group()
def howmuch():
    """Base command for howmuch related operations."""
    pass

@howmuch.command()
@click.argument('symbol')
@click.pass_context
def quote(ctx, symbol: str):
    if symbol == "favorites":
        """Get the current price quote of favorites."""
        user_id = ctx.obj.get('user_id')
        favorites_quotes = api.get_favorites_quote(user_id)
        if favorites_quotes:
            for fav_quote in favorites_quotes:
                click.echo(f'{fav_quote.get('symbol')}: {fav_quote.get('price')}')
        else:
            click.echo(f'Failed to get favorites quotes for user {user_id}.')
    else:
        """Get the current price quote of a stock."""
        price_data = api.get_quote(symbol)
        if price_data:
            click.echo(f'Current price for {symbol} is {price_data["price"]}')
        else:
            click.echo(f'Error getting quote for {symbol}')

@howmuch.command()
@click.argument('symbol')
@click.pass_context
def add(ctx, symbol: str):
    """Add a new stock to favorites."""
    user_id = ctx.obj.get('user_id')
    success = api.add_to_favorites(user_id, symbol)
    if success:
        click.echo(f'Item "{symbol}" added successfully.')
    else:
        click.echo(f'Failed to add symbol "{symbol}".')

@howmuch.command()
@click.argument('keyword')
@click.pass_context
def get(ctx, keyword: str):
    if keyword == "favorites":
        """Get all favorite items."""
        user_id = ctx.obj.get('user_id')
        favorites = api.get_favorites(user_id)
        if favorites:
            for idx, fav in enumerate(favorites):
                click.echo(f'{idx+1}. {fav.get('ticker')}')
        else:
            click.echo(f'Failed to get favorites for user {user_id}.')


def main_loop():
    """Main interactive loop for CLI."""
    user_id = authenticate()  # Authenticate once at the start
    while True:
        try:
            user_input = click.prompt("Enter command", type=str)
            if user_input.lower() == "exit":
                click.echo("Exiting application.")
                break
            args = user_input.split()
            if not args:
                continue
            ctx = cli.make_context(info_name="cli", args=args, obj={'user_id': user_id})
            cli.invoke(ctx)
        except click.exceptions.Abort:
            break
        except SystemExit:
            break
        except Exception as e:
            click.echo(f'An unexpected error occurred: {e}')

if __name__ == '__main__':
    main_loop()