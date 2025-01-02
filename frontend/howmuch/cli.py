import click
import json
import os
import api

@click.group()
def cli():
    user_name = click.prompt("Please enter your user name to register or login", type=str)
    user_exists = api.check_if_user_exists(user_name).get('exist')
    if not user_exists:
        register_user = click.confirm(f'User {user_name} does not exist. Would you like to register?', default=True)
        if register_user:
            api.register_user(user_name)
        else:
            exit()
    else:
        click.echo(f'Welcome, {user_name}!')
    return

@click.command()
@click.argument('symbol', type=str)
def quote(symbol: str):
    price_data = api.get_quote(symbol)
    if price_data:
        click.echo(f'Current price for {symbol} is {price_data["price"]}')
    else:
        click.echo(f'Error getting quote for {symbol}')


def main_loop():
    while True:
        try:
            cli()
            user_input = click.prompt("Enter command", type=str)
            if user_input.lower() == "exit":
                break
        except click.exceptions.Abort:
            break
        except SystemExit:
            break
        except Exception as e:
            print(f'An unexpected error occured: {e}')

if __name__ == '__main__':
    main_loop()